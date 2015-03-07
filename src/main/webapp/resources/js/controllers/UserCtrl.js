function UserCtrl($scope, Users, TaskLists, Tasks) {
    $scope.user = {};
    $scope.isFriend = '';
    $scope.taskLists = {};

    Users.byId($routeParams.id).success(function (data) {
        $scope.user = data;

        Users.isFriend($scope.user.id).success(function (data) {
            $scope.isFriend = data;
        });

        Users.taskLists($scope.user.id).success(function (data) {
            $scope.taskLists = data;
        });
    });

    $scope.loadTasks = function (taskListId) {
        var tasks = {};
        Tasks.all(taskListId).success(function (data) {
            tasks = data;
        });
        return tasks;
    };

    $scope.editTaskStatus = function (tasks, task, status) {
        Tasks.setStatus(task.idTasklist, task.id, status).success(function (data) {
            var index = tasks.indexOf(task);
            tasks.splice(index, 1);
            if (tasks.length === $scope.countNotDoTasks(task.idTasklist)) {
                TaskLists.delete(task.idTasklist);
            }
        });
    };

    $scope.removeFromFriends = function(user) {
        Users.removeFromFriends(user.id);
    };

    $scope.addToFriends = function(user) {
        Users.addToFriends(user.id);
    };

    $scope.countNotDoTasks = function (taskListId) {
        return TaskLists.countNotDoTasks(taskListId);
    };

    $scope.countTasks = function (taskListId) {
        return TaskLists.countTasks(taskListId);
    };

}

angular
    .module('taskerApp')
    .controller('UserCtrl', UserCtrl);

