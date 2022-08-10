//Start Delete Address
function deleteAddress(adr, id) {
    $(".address").text(adr);
    $("#deleteAddress").attr("href", "/DTNsBike/update_account.html/delete/" + id);
}
//End Delete Address

//Start Update Address
function updateAddress(adr, id) {
    $('#editAddress').val(adr);
    $("#updateAddress").attr("formaction", "/DTNsBike/update_account.html/update/" + id);
}
function updateAdr() {
    var adr = String($("#editAddress").val());
    if (adr.trim().length == 0) {
        $(".errorsAdr").text("Không bỏ trống ô nhập địa chỉ");
        return false;
    } else {
        return true;
    }
}
//End Update Address
//Start Create Address
function createAdr() {
    var adr = String($("#newAddress").val());
    if (adr.trim().length == 0) {
        $("#errorsAdr").text("Không bỏ trống ô nhập địa chỉ");
        return false;
    } else {
        $("#errorsAdr").text("");
        return true;
    }
}

$(document).ready(function () {

    $('textarea').keypress(function (event) {

        if (event.keyCode == 13) {
            event.preventDefault();
        }
    });
});
//End Create Address

//Angular.js 
//Upload Avatar
var app = angular.module("gemApp", []);
app.controller("myctr", function ($scope, $http) {
    var url = "http://localhost:8080/DTNsBike/update_account.html/avatar"
    $scope.url = function (filename) {
        return url+'/'+filename;
    }
    $scope.list = function () {
        $http.get(url).then(resp => {
            $scope.filename = resp.data;
        }).catch(error => {
            console.log("Errors", error);
        });
    }
    $scope.upload = function (files) {
        var form = new FormData();
        for (var i = 0; i < files.length; i++) {
            form.append("files", files[i]);
        }
        $http.post(url, form, {
            transformRwquest: angular.identity,
            headers: { 'Content-Type': undefined }
        }).then(resp=>{
            $scope.filenames.push(...resp.data);
        }).catch(error=>{
            console.log("Errors",error);
        })
    }
})