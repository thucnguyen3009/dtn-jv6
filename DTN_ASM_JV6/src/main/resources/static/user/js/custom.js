// var app = angular.module("myapp",[]);
//         app.controller("myctr", function ($scope,$location) {
//             //Start Delete Address
//             $scope.deleteAddress = function(adr,x){
//                 $scope.address=adr;
//                 $scope.id=x;
//             };
//             $scope.post = function() {
//                 $location.url('/delete/'+$scope.id);
//             }
//             //End Delete Address
//         })
function deleteAddress(adr,id){
    $(".address").text(adr);
    $("#deleteAddress").attr("href", "/DTNsBike/update_account.html/delete/"+id);}
