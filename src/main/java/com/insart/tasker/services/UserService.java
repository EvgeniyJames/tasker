package com.insart.tasker.services;

import com.insart.tasker.dao.FriendshipDAO;
import com.insart.tasker.dao.UserDAO;
import com.insart.tasker.enums.FriendshipStatus;
import com.insart.tasker.model.Friendship;
import com.insart.tasker.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.Collections.EMPTY_SET;

/**
 * User: Evgeniy James
 * Date: 22.02.2015
 */
@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private FriendshipDAO friendshipDAO;

    @Autowired
    private TasklistService tasklistService;

    /**
     * Список всех Юзеров
     *
     * @return List of Users
     */
    public List<User> findAll() {
        return userDAO.findAll();
    }


    /**
     * Сохранить Юзера в БД
     *
     * @param user User to save in DB
     * @return User, that saved in DB
     */
    public User save(User user) {
        if (userDAO.findByLogin(user.getLogin()) == null) {
            return userDAO.save(user);
        } else {
            return new User();
        }
    }

    public void delete(Long id) {
        friendshipDAO.deleteByIdUserCustom(id);
        tasklistService.deleteByIdAuthor(id);
        userDAO.delete(id);
    }

    /**
     * Послать запрос на дружбу
     *
     * @param idOne User who send request
     * @param idTwo User whom send request
     * @return Friendship object in DB. If NULL - Запись уже существует или обновлена
     */
    public Friendship sendFriendshipRequest(Long idOne, Long idTwo) {

        User one = userDAO.findOne(idOne);
        User two = userDAO.findOne(idTwo);

        if (one == null || two == null) {
            return new Friendship();
        }

        List<Friendship> byIdOneAndIdTwo = friendshipDAO.findByIdOneAndIdTwo(one.getId(), two.getId());

        /**
         * Проверяем наличие запроса в друзья от Первого Второму
         */
        if (byIdOneAndIdTwo.isEmpty()) {
            List<Friendship> byIdOneAndIdTwo1 = friendshipDAO.findByIdOneAndIdTwo(two.getId(), one.getId());

            /**
             * Если обратной записи нет, создаём объект Friendship
             */
            if (byIdOneAndIdTwo1.isEmpty()) {
                Friendship friendship = new Friendship();
                friendship.setIdTwo(two.getId());
                friendship.setIdOne(one.getId());
                friendship.setRelationship(FriendshipStatus.INVITE);
                return friendshipDAO.save(friendship);
            }
            /**
             * Если обратная запись есть, значит Юзера уже добавляет второй Юзер
             * Меняем статус INVITE на FRIENDS
             */
            else {
                Friendship friendship = byIdOneAndIdTwo1.get(0);

                /**
                 * Если между ними отношение INVITE, назначаем отношению статус FRIENDS
                 */
                if (friendship.getRelationship() == FriendshipStatus.INVITE) {
                    friendship.setRelationship(FriendshipStatus.FRIENDS);
                    friendshipDAO.save(friendship);
                    friendship = new Friendship();
                    friendship.setIdOne(one.getId());
                    friendship.setIdTwo(two.getId());
                    friendship.setRelationship(FriendshipStatus.FRIENDS);
                    friendshipDAO.save(friendship);
                    return sendFriendshipRequest(two.getId(), one.getId());
                }
            }
        }
        return new Friendship();
    }

    /**
     * Удаление друга из списка
     *
     * @param idOne - Удаляющий Юзер
     * @param idTwo - Удаляемый Юзер
     */
    public void deleteFriend(Long idOne, Long idTwo) {

        User one = userDAO.findOne(idOne);
        User two = userDAO.findOne(idTwo);


        if (one == null || two == null) {
            return;
        }
        friendshipDAO.delete(friendshipDAO.findByIdOneAndIdTwo(one.getId(), two.getId()));
        friendshipDAO.delete(friendshipDAO.findByIdOneAndIdTwo(two.getId(), one.getId()));
    }

    /**
     * Найти всех друзей пользователя
     *
     * @param idUser User that will find friends
     * @return Set of user's friends
     */
    public Set findUserFriends(Long idUser) {

        User user = userDAO.findOne(idUser);

        if (user == null) {
            return EMPTY_SET;
        }
        return findUsersPeopleByRelationship(user, FriendshipStatus.FRIENDS);
    }

    /**
     * Найти всех Юзеров, которым user отправил запросы
     *
     * @param idUser
     * @return
     */
    public Set<User> findUserRequestsFriends(Long idUser) {

        User user = userDAO.findOne(idUser);

        if (user == null) {
            return EMPTY_SET;
        }

        return findUsersPeopleByRelationship(user, FriendshipStatus.INVITE);
    }

    /**
     * Выбрать пользователей, которые отправили запрос на дружбу с user
     *
     * @param idUser - Искомый Юзер
     * @return - Сет Юзеров, которые добавляют user
     */
    public Set<User> findUserInviters(Long idUser) {

        User user = findUserById(idUser);

        if (user == null) {
            return Collections.emptySet();
        }

        Set<Friendship> byIdTwoAndRelationship = friendshipDAO.findByIdTwoAndRelationship(user.getId(), FriendshipStatus.INVITE);
        Set<User> users = new HashSet<>();
        for (Friendship friendship : byIdTwoAndRelationship) {
            users.add(userDAO.findOne(friendship.getIdOne()));
        }
        return users;
    }

    public User findUserById(Long id) {
        return userDAO.findOne(id);
    }


    /*    SERVICE PRIVATE METHODS     */

    private Set<User> findUsersPeopleByRelationship(User user, FriendshipStatus relationship) {
        List<Friendship> byIdOne = friendshipDAO.findByIdOneAndRelationship(user.getId(), relationship);
        Set<User> users = new HashSet<>();
        for (Friendship friendship : byIdOne) {
            users.add(userDAO.findOne(friendship.getIdTwo()));
        }
        return users;
    }

    private boolean isFriends(User one, User two) {
        return findUserFriends(one.getId()).contains(two);
    }

}
