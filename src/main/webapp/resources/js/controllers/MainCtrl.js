function MainCtrl($scope, $location) {
    $scope.isCollapsed = true;

    $scope.$on('$routeChangeSuccess', function () {
        $scope.isCollapsed = true;
    });

    $scope.$location = $location;

    $scope.collapseClc = function (index) {
        $("#" + index).collapse('toggle')
    };
}

angular
    .module('taskerApp')
    .controller('MainCtrl', MainCtrl);
