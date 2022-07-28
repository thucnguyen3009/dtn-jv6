app.controller("historysale",function($scope,$http){
    $scope.$on('$routeChangeSuccess', function(event, current, previous) {
        $scope.page.setTitle(current.$$route.title || ' Lịch Sử Đổi Giá');
    });
});