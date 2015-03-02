angular.module('taskerApp')
    .controller('UsersController', [ '$scope', '$http', function ($scope, $http) {

        $scope.users = {};

        $scope.loadUsers = function(){
            $http.get('http://localhost:8080/user/getUsers/')
                .success(function(data, status, headers, config) {
                    $scope.users = data;
                })
                .error(function(data, status, headers, config) {
                    alert('Error loading tasks');
                });
        };

        $scope.loadUsers();
    }]);