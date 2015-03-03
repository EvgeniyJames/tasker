var taskerApp = angular.module('taskerApp',['ngRoute']);

taskerApp.config(['$routeProvider','$locationProvider',
    function($routeProvider, $locationProvider) {
        $routeProvider
            .when('/', {
                templateUrl: '/resources/templates/login.html'
            })
            .when('/register', {
                templateUrl: '/resources/templates/register.html'
            })
            .when('/tasks', {
                templateUrl: '/resources/templates/tasks.html',
                controller: 'TasksCtrl'
            })
            .when('/findUsers', {
                templateUrl: '/resources/templates/findUsers.html',
                controller: 'FindUsersCtrl'
            })
            .when('/me', {
                templateUrl: '/resources/templates/me.html',
                controller: 'MeCtrl'
            })
            .when('/user', {
                templateUrl: '/resources/templates/user.html',
                controller: 'UserCtrl'
            })
            .when('/friends', {
                templateUrl: '/resources/templates/friends.html',
                controller: 'FriendsCtrl'
            })
            .otherwise({
                redirectTo: '/'
            });

    }]);