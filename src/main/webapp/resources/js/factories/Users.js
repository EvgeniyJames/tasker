(function () {
    'use strict';

    function Users($http) {
        var BASE_URL = '/user';
        return {
            all: function () {
                return $http.get(BASE_URL);
            },
            me: function () {
                return $http.get(BASE_URL + '/me');
            },
            byId: function (id) {
                return $http.get(BASE_URL + '/' + id);
            },
            friends: function () {
                return $http.get(BASE_URL + '/friend');
            },
            removeFromFriends: function (id) {
                return $http.delete(BASE_URL + '/friend' + id);
            },
            getFriendRequests: function () {
                return $http.get(BASE_URL + '/request');
            },
            sendFriendRequest: function (id) {
                return $http.post(BASE_URL + '/' + id + '/request');
            },
            acceptFriendRequest: function (id) {
                return $http.put(BASE_URL + '/' + id + '/request/');
            },
            declineFriendRequest: function (id) {
                return $http.delete(BASE_URL + '/' + id + '/request');
            },
            byLogin: function (login) {
                return $http.get(BASE_URL + '/search/' + login);
            },
            create: function (user) {
                return $http.post(BASE_URL + '/', user);
            },
            delete: function (id) {
                return $http.delete(BASE_URL + '/' + id);
            },
            taskLists: function (id) {
                return $http.get(BASE_URL + '/' + id + '/tasklist');
            },
            isFriend: function (id) {
                return $http.get(BASE_URL + '/' + id + '/friend');
            }
        };
    }

    angular
        .module('taskerApp')
        .factory('Users', Users);
})();

