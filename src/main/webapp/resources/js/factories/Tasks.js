(function () {
    'use strict';

    function Tasks($http) {
        var BASE_URL = '/task';
        return {
            all: function (tasksListId) {
                return $http.get(BASE_URL + '/' + tasksListId + '/task');
            },
            byId: function (tasksListId, id) {
                return $http.get(BASE_URL + '/' + tasksListId + '/task/' + id);
            },
            create: function (tasksListId, task) {
                return $http.post(BASE_URL + '/' + tasksListId + '/task', task);
            },
            delete: function (tasksListId, id) {
                return $http.delete(BASE_URL + '/' + tasksListId + '/task/' + id);
            },
            setStatus: function (tasksListId, id, status) {
                return $http.put(BASE_URL + '/' + tasksListId + '/task/' + id + '/status' + status);
            }
        };
    }

    angular
        .module('taskerApp')
        .factory('Tasks', Tasks);
})();

