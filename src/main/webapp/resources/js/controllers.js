angular.module('taskerApp')
    .controller('TasksController', [ '$scope', '$http', function ($scope, $http) {

        $scope.tasks = {};

        $scope.loadTasks = function(){
            $http.get('http://localhost:8080/task/')
                .success(function(data, status, headers, config) {
                    $scope.tasks = data;
                })
                .error(function(data, status, headers, config) {
                    alert('Error loading tasks');
                });
        };


        $scope.loadTasks();
    }]);