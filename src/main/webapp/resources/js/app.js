angular.module('taskerApp', ['ngRoute'])
    .config(['$routeProvider', '$locationProvider',
        function ($routeProvider, $locationProvider) {
            $routeProvider
                .when('/login', {
                    templateUrl: '/resources/templates/login.html',
                    controller: 'LoginCtrl'
                })
                .when('/register', {
                    templateUrl: '/resources/templates/register.html',
                    controller: 'RegisterCtrl'
                })
                .when('/tasklists', {
                    templateUrl: '/resources/templates/tasklists.html',
                    controller: 'TasklistsCtrl'
                })
                .when('/search', {
                    templateUrl: '/resources/templates/search.html',
                    controller: 'SearchCtrl'
                })
                .when('/', {
                    templateUrl: '/resources/templates/me.html',
                    controller: 'MeCtrl'
                })
                .when('/user/:id', {
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