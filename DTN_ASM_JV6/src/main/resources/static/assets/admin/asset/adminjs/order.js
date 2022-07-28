app.controller("order-wait",function($scope,$http){
    $scope.$on('$routeChangeSuccess', function(event, current, previous) {
        $scope.page.setTitle(current.$$route.title || ' Đơn hàng đang chờ');
    });
});
app.controller("order-delivered",function($scope,$http){
    $scope.$on('$routeChangeSuccess', function(event, current, previous) {
        $scope.page.setTitle(current.$$route.title || ' Đơn hàng đang giao');
    });
});
app.controller("order-done",function($scope,$http){
    $scope.$on('$routeChangeSuccess', function(event, current, previous) {
        $scope.page.setTitle(current.$$route.title || ' Đơn hàng đã giao');
    });
});
app.controller("order-cancel",function($scope,$http){
    $scope.$on('$routeChangeSuccess', function(event, current, previous) {
        $scope.page.setTitle(current.$$route.title || ' Đơn hàng đã huỷ');
    });
});
app.controller("order-details",function($scope,$http){
    $scope.$on('$routeChangeSuccess', function(event, current, previous) {
        $scope.page.setTitle(current.$$route.title || ' Thông tin chi tiết đơn hàng | DH001');
    });
});