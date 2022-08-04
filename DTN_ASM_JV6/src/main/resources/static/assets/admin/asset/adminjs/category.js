let host = "http://localhost:8080/rest";

var test = 0;
var key = null;
var form = {};

// Category List Controller
app.controller("category-list",function($scope,$http){
    $scope.$on('$routeChangeSuccess', function(event, current, previous) {
        $scope.page.setTitle(current.$$route.title || ' Danh sách danh mục');
    });

    $scope.items = [];
    $scope.headers =[];
    $scope.form = {};

     $scope.load_All = function () {
        var url = `${host}/categories`;
        $http.get(url).then(resp => {
            $scope.items = resp.data;
            // GET JSON ARRAY HEADERS.
            $scope.headers = Object.keys($scope.items[0]);
            $scope.columns = $scope.headers[1];
            // Search 

            $scope.changeFilterTo = function (pr) {
                if ($scope.search) {
                    var value = "";
                    for (var key in $scope.search) {
                        if ($scope.search[key]) {
                            value = angular.copy($scope.search[key]);
                            $scope.search[key] = undefined;
                        }
                    }
                    $scope.search[pr] = value;
                }
            }
            $scope.pageSize = 5;

            $scope.begin = 0;
            $scope.length = Object.keys($scope.items).length;
            $scope.pageCount = Math.ceil($scope.length / $scope.pageSize);
            $scope.index2 = $scope.length;
            
            // $scope.prop ='id';
            console.log("Success", resp)
        }).catch(error => {
            console.log("Error", error);
        });

    }
    $scope.delete = function (id) {
        Swal.fire({
            position: 'top',
            title: 'Thông báo?',
            text: "Bạn chắc chắn muốn xóa danh mục "+id+" này!?",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Yes, delete it!'
        }).then((result) => {
            if (result.isConfirmed) {
                // var url = `${host}/categories/${id}`;
                // $http.delete(url).then(resp => {
                //     var index = $scope.items.findIndex(item => item.id == id);
                //     $scope.items.splice(index, 1);

                //     $scope.reset();
                //     $scope.load_All();
                //     console.log("Success", resp)
                // }).catch(error => {
                //     console.log("Error", error);
                // });
                Swal.fire(
                    'Xóa thành công!',
                    'Đã xóa id ' + id,
                    'success'
                )
            }
        })
    }

    $scope.edit = function (id) {
        key = id;
        test = 1;
    }


    $scope.index = 1;   
    $scope.repaginate = function () {
        $scope.begin = 0;
        $scope.length = Object.keys($scope.items).length;
        $scope.pageCount = Math.ceil($scope.length / $scope.pageSize);
        $scope.index2 = ($scope.pageCount - 1) * $scope.pageSize;
    }
    $scope.prop2 = 0;
    $scope.sortBy = function (prop) {
       if($scope.prop2 == 0){
             $scope.prop = prop;
              $scope.prop2 = 1;
       }else{
             $scope.prop = '-'+prop;
             $scope.prop2 = 0;
       }
    }

    $scope.first = function () {
        $scope.begin = 0;
    }
    $scope.prev = function () {
        if ($scope.begin > 0) {
            $scope.begin -= $scope.pageSize;
            $scope.index = $scope.begin + 1;

        }
    }

    $scope.next = function () {
        if ($scope.begin < ($scope.pageCount - 1) * $scope.pageSize) {
            $scope.begin += $scope.pageSize;
            $scope.index = $scope.begin;
        }
    }

    $scope.last = function () {
        $scope.begin = ($scope.pageCount - 1) * $scope.pageSize;
    }

    $scope.load_All();

});


// Category Form Controller :)))
app.controller("category-form",function($scope,$http){
    $scope.$on('$routeChangeSuccess', function(event, current, previous) {
        $scope.page.setTitle(current.$$route.title || ' Form Danh mục');
    });
    if(test > 0){
        $scope.showButton = false;
        test = 0;
    }else{
        $scope.showButton = true;
    }

   $scope.form = {};

   $scope.load = function(){
       if(key != null){
            var url = `${host}/categories/${key}`;
            $http.get(url).then(resp => {
                $scope.form = resp.data;
                form = $scope.form;
                console.log("Success", resp)
            }).catch(error => {
                console.log("Error", error);
            });
            key = null;
       }else{
            $scope.reset();

       }
   }

   $scope.reset = function () {
        $scope.form = {};
        $scope.showButton = true;
    }
    $scope.load();
});

app.directive('convertToNumber', function () {
    return {
        require: 'ngModel',
        link: function (scope, element, atrs, ngModel) {
            ngModel.$parsers.push(function (val) {
                return parseInt(val, 10);
            });
            ngModel.$formatters.push(function (val) {
                return '' + val;
            });
        }

    }
})
