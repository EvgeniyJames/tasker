function RegisterCtrl($scope, Users) {
    $scope.confirmPassword = '';

    $scope.saveData = function (newUser, confirmPassword) {
        var isValid = true;
        $scope.passwordRequired = '';
        $scope.loginRequired = '';

        if (newUser.password != confirmPassword) {
            isValid = false;
            $scope.passwordRequired = 'Passwords do not match';
        } else {
            $scope.passwordRequired = '';
        }

        /*if (Users.byLogin(newUser.login) != null) {
            isValid = false;
            $scope.loginRequired = 'This login is already used';
        } else {
            $scope.loginRequired = '';
        }*/

        if (isValid) {
            Users.create(newUser);
        }
    };
}

angular
    .module('taskerApp')
    .controller('RegisterCtrl', RegisterCtrl);