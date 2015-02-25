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
            .when('/me', {
                templateUrl: '/resources/templates/me.html',
                controller: 'MeCtrl'
            })
            .otherwise({
                redirectTo: '/'
            });

    }]);