function TasklistsCtrl($scope, TaskLists, Tasks, Users) {
    $scope.taskLists = {};
    $scope.friends = {};

    var me = {};

    Users.me().success(function (data) {
        me = data;
    });

    TaskLists.byMe().success(function (data) {
        $scope.taskLists = data;
    });

    Users.friends().success(function (data) {
        $scope.friends = data;
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
            if (tasks.length === $scope.countNotDoTasks(task.idTasklist)) {
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

    $scope.taskAdd = function (taskList, newTask) {
        Tasks.create(taskList.id, newTask).success(function (data) {
            taskList.push(data);
        });
    };

    $scope.taskListAdd = function (executor, newTaskList) {
        newTaskList.idExecutor = executor.id;
        newTaskList.idAuthor = me.id;
        TaskLists.create(newTaskList).success(function (data) {
            $scope.taskLists.push(data);
        });
    };
}

angular
    .module('taskerApp')
    .controller('TasklistsCtrl', TasklistsCtrl);

