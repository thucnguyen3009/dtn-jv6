app.controller("account-form",function($scope,$http){
    // alert("QUẢN LÝ TÀI KHOẢN");
    $scope.$on('$routeChangeSuccess', function(event, current, previous) {
        $scope.page.setTitle(current.$$route.title || ' Cập nhật tài khoản');
    });
});
app.controller("account-list",function($scope,$http){
    // alert("QUẢN LÝ TÀI KHOẢN");
    $scope.$on('$routeChangeSuccess', function(event, current, previous) {
        $scope.page.setTitle(current.$$route.title || ' Danh sách tài khoản');
    });
});