angular.module('taskerApp')
    .controller('TasksCtrl', ['$scope', '$http', function ($scope, $http) {

        $scope.tasks = {};

        $scope.loadTasks = function () {
            $http.get('http://localhost:8080/task/getAll')
                .success(function (data, status, headers, config) {
                    $scope.tasks = data;
                })
                .error(function (data, status, headers, config) {
                    alert('Error loading tasks');
                });
        };

        $scope.loadTasks();
    }])

    .controller('FindUsersCtrl', ['$scope', '$http', function ($scope, $http) {

        $scope.findedUsers = {};
        $scope.loadFindedUsers = function () {
            $http.get('http://localhost:8080/user/getUsers')
                .success(function (data, status, headers, config) {
                    $scope.findedUsers = data;
                })
                .error(function (data, status, headers, config) {
                    alert('Error loading findedUsers');
                });
        };

        $scope.loadFindedUsers();
    }])

    .controller('NavCtrl', ['$scope', '$location', function ($scope, $location) {
        $scope.isCollapsed = true;
        $scope.$on('$routeChangeSuccess', function () {
            $scope.isCollapsed = true;
        })

        $scope.$location = $location;
    }])

    .controller('MeCtrl', ['$scope', function ($scope) {

        $scope.collapseClc = function (index) {
            $("#" + index).collapse('toggle')
        }

        $scope.doneClick = function () {

        }

        $scope.removeClick = function () {

        }
    }])

    .controller('UserCtrl', ['$scope', function ($scope) {

        $scope.collapseClc = function (index) {
            $("#" + index).collapse('toggle')
        }

        $scope.isFriend = function () {
            return true;
        }
    }])
    .controller('FriendsCtrl', ['$scope', function ($scope) {


    }]);