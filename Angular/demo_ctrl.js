let host = "https://poly-java6-e4363-default-rtdb.firebaseio.com";
const app = angular.module("app", []);
app.controller("ctrl", function ($scope, $http) {
    $scope.form = {}
    $scope.items = {}
    $scope.reset = function () {
        $scope.form = { gender: true, country: 'VN' };
        $scope.key = null;
    }
    $scope.load_all = function () {
        var url = `${host}/user.json`;
        $http.get(url).then(resp => {
            $scope.items = resp.data;
            console.log("Success", resp)
        }).catch(error => {
            console.log("Error", error)
        });
    }
    $scope.edit = function (key) {
        var url = `${host}/user/${key}.json`;
        $http.get(url).then(resp => {
            $scope.form = resp.data;
            $scope.key = key;
            console.log("Success", resp)
        }).catch(error => {
            console.log("Error", error)
        })
    }
    $scope.update = function () {
        var item = angular.copy($scope.form);
        var url = `${host}/user/${$scope.key}.json`;
        $http.put(url, item).then(resp => {
            $scope.items[$scope.key] = resp.data;
            console.log("Success", resp)
        }).catch(error => {
            console.log("Error", error)
        })
    }
    $scope.delete = function (key) {
        var url = `${host}/user/${key}.json`;
        $http.delete(url).then(resp => {
            delete $scope.items[key];
            $scope.reset();
            console.log("Success", resp)
        }).catch(error => {
            console.log("Error", error)
        });
    }
    $scope.create = function () {
        var item = angular.copy($scope.form);
        var url = `${host}/user.json`;
        $http.post(url, item).then(resp => {
            $scope.key = resp.data.name;
            $scope.items[$scope.key] = item;
            $scope.reset();
            console.log("Sucess", resp)
        }).catch(error => {
            console.log("Error", error)
        })
    }
    $scope.load_all();
    $scope.reset();

});