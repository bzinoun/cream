'use strict';

angular.module('creamApp').controller('PerferenceDialogController',
    ['$scope', '$stateParams', '$uibModalInstance', 'DataUtils', 'entity', 'Perference',
        function($scope, $stateParams, $uibModalInstance, DataUtils, entity, Perference) {

        $scope.perference = entity;
        $scope.load = function(id) {
            Perference.get({id : id}, function(result) {
                $scope.perference = result;
            });
        };

        var onSaveSuccess = function (result) {
            $scope.$emit('creamApp:perferenceUpdate', result);
            $uibModalInstance.close(result);
            $scope.isSaving = false;
        };

        var onSaveError = function (result) {
            $scope.isSaving = false;
        };

        $scope.save = function () {
            $scope.isSaving = true;
            if ($scope.perference.id != null) {
                Perference.update($scope.perference, onSaveSuccess, onSaveError);
            } else {
                Perference.save($scope.perference, onSaveSuccess, onSaveError);
            }
        };

        $scope.clear = function() {
            $uibModalInstance.dismiss('cancel');
        };

        $scope.abbreviate = DataUtils.abbreviate;

        $scope.byteSize = DataUtils.byteSize;
        $scope.datePickerForDateImport = {};

        $scope.datePickerForDateImport.status = {
            opened: false
        };

        $scope.datePickerForDateImportOpen = function($event) {
            $scope.datePickerForDateImport.status.opened = true;
        };

        $scope.setPieceJointe = function ($file, perference) {
            if ($file) {
                var fileReader = new FileReader();
                fileReader.readAsDataURL($file);
                fileReader.onload = function (e) {
                    var base64Data = e.target.result.substr(e.target.result.indexOf('base64,') + 'base64,'.length);
                    $scope.$apply(function() {
                        perference.pieceJointe = base64Data;
                        perference.pieceJointeContentType = $file.type;
                    });
                };
            }
        };
}]);
