var taskerApp = angular.module('taskerApp',['ngRoute']);

taskerApp.config(['$routeProvider','$locationProvider',
    function($routeProvider, $locationProvider) {
        $routeProvider
            .when('/', {
                templateUrl: '/resources/templates/tasks.html',
                controller: 'TasksController'
            })
            .otherwise({
                redirectTo: '/'
            });

    }]);