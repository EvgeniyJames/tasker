function MeCtrl($scope, TaskLists, Tasks, Users) {
    $scope.taskLists = {};
    $scope.me = {};

    Users.me().success(function (data) {
        $scope.me = data;
    });

    TaskLists.all().success(function (data) {
        $scope.taskLists = data;
    });

    $scope.loadTasks = function (taskListId) {
        var tasks = {};
        Tasks.all(taskListId).success(function (data) {
            tasks = data;
        });
        return tasks;
    };

    $scope.nameById = function(id) {
        var name = "";
        Users.byId(id).success(function(data) {
            name = data.name;
        });
        return name;
    };


    $scope.editTaskStatus = function (tasks, task, status) {
        Tasks.setStatus(task.idTasklist, task.id, status).success(function (data) {
            var index = tasks.indexOf(task);
            tasks.splice(index, 1);
            if(tasks.length ===  $scope.countNotDoTasks(task.idTasklist)) {
                TaskLists.delete(task.idTasklist);
            }
        });
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
    .controller('MeCtrl', MeCtrl);
