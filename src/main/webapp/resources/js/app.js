var taskerApp = angular.module('taskerApp',['ngRoute']);

taskerApp.config(['$routeProvider','$locationProvider',
    function($routeProvider, $locationProvider) {
        $routeProvider
            .when('/', {
                templateUrl: '/resources/templates/login.html',
                controller: 'TasksController'
            })
            .when('/register', {
                templateUrl: '/resources/templates/register.html',
                controller: 'TasksController'
            })
            .when('/tasks', {
                templateUrl: '/resources/templates/tasks.html',
                controller: 'TasksController'
            })
            .otherwise({
                redirectTo: '/'
            });

    }]);