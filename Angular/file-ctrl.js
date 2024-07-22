var app = angular.module("app", []);

app.controller("ctrl", function ($scope, $http) {
    var url = 'http://localhost:8080/rest/files/images';
    
    $scope.filenames = [];  // Initialize the filenames array

    $scope.url = function (filename) {
        return `${url}/${filename}`;
    }

    $scope.list = function () {
        $http.get(url).then(function (resp) {
            $scope.filenames = resp.data;
        }).catch(function (error) {
            console.log("Error", error);
        });
    }

    $scope.upload = function (files) {
        var form = new FormData();
        for (var i = 0; i < files.length; i++) {
            form.append("files", files[i]);
        }
        $http.post(url, form, {
            transformRequest: angular.identity,
            headers: { 'Content-Type': undefined }
        }).then(function (resp) {
            $scope.filenames.push(...resp.data);
        }).catch(function (error) {
            console.log("Error", error);
        });
    }

    $scope.delete = function (filename) {
        $http.delete(`${url}/${filename}`).then(function (resp) {
            var i = $scope.filenames.findIndex(name => name === filename);
            if (i !== -1) {
                $scope.filenames.splice(i, 1);
            }
        }).catch(function (error) {
            console.log("Error", error);
        });
    }

    $scope.list();
});
