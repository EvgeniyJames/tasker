function FriendsCtrl($scope, Users) {
    $scope.friends = {};
    $scope.requests = {};

    Users.friends().success(function(data) {
       $scope.friends = data;
    });

    Users.getFriendRequests().success(function(data) {
       $scope.requests = data;
    });

    $scope.removeFromFriends = function(friend) {
        Users.removeFromFriends(friend.id).success(function(data) {
            var index = $scope.friends.indexOf(friend);
            $scope.friends.splice(index, 1);
        });
    };

    $scope.accept = function(request) {
        Users.acceptFriendRequest(request.id).accept(function(data) {
            var index = $scope.requests.indexOf(request);
            $scope.requests.splice(index, 1);
            $scope.friends.push(data);
        });
    };

    $scope.decline = function(request) {
        Users.declineFriendRequest(request.id).accept(function(data) {
            var index = $scope.requests.indexOf(request);
            $scope.requests.splice(index, 1);
        });
    };

}

angular
    .module('taskerApp')
    .controller('FriendsCtrl', FriendsCtrl);

