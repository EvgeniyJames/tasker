(function () {
    'use strict';

    function TaskLists($http) {
        var BASE_URL = '/tasklist';
        return {
            all: function () {
                return $http.get(BASE_URL);
            },
            byMe: function() {
                return $http.get(BASE_URL + '/byme')
            },
            byId: function (id) {
                return $http.get(BASE_URL + '/' + id);
            },
            create: function (taskList) {
                return $http.post(BASE_URL, taskList);
            },
            delete: function (id) {
                return $http.delete(BASE_URL + '/' + id);
            },
            countNotDoTasks: function (id) {
                return $http.get(BASE_URL + '/' + id + '/donot');
            },
            countTasks: function(id) {
                return $http.get(BASE_URL + '/' + id + '/count');
            }
        };
    }

    angular
        .module('taskerApp')
        .factory('TaskLists', TaskLists);
})();
