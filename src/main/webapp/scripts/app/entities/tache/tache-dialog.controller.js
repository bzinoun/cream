'use strict';

angular.module('creamApp').controller('TacheDialogController',
    ['$scope', '$stateParams', '$uibModalInstance', 'DataUtils', 'entity', 'Tache', 'Prospection', 'Action', 'RefStatutTache',
        function($scope, $stateParams, $uibModalInstance, DataUtils, entity, Tache, Prospection, Action, RefStatutTache) {

        $scope.tache = entity;
        $scope.prospections = Prospection.query();
        $scope.actions = Action.query();
        $scope.refstatuttaches = RefStatutTache.query();
        $scope.load = function(id) {
            Tache.get({id : id}, function(result) {
                $scope.tache = result;
            });
        };

        var onSaveSuccess = function (result) {
            $scope.$emit('creamApp:tacheUpdate', result);
            $uibModalInstance.close(result);
            $scope.isSaving = false;
        };

        var onSaveError = function (result) {
            $scope.isSaving = false;
        };

        $scope.save = function () {
            $scope.isSaving = true;
            if ($scope.tache.id != null) {
                Tache.update($scope.tache, onSaveSuccess, onSaveError);
            } else {
                Tache.save($scope.tache, onSaveSuccess, onSaveError);
            }
        };

        $scope.clear = function() {
            $uibModalInstance.dismiss('cancel');
        };

        $scope.abbreviate = DataUtils.abbreviate;

        $scope.byteSize = DataUtils.byteSize;
        $scope.datePickerForDateDebut = {};

        $scope.datePickerForDateDebut.status = {
            opened: false
        };

        $scope.datePickerForDateDebutOpen = function($event) {
            $scope.datePickerForDateDebut.status.opened = true;
        };
        $scope.datePickerForDateFin = {};

        $scope.datePickerForDateFin.status = {
            opened: false
        };

        $scope.datePickerForDateFinOpen = function($event) {
            $scope.datePickerForDateFin.status.opened = true;
        };

        $scope.setPieceJointe = function ($file, tache) {
            if ($file) {
                var fileReader = new FileReader();
                fileReader.readAsDataURL($file);
                fileReader.onload = function (e) {
                    var base64Data = e.target.result.substr(e.target.result.indexOf('base64,') + 'base64,'.length);
                    $scope.$apply(function() {
                        tache.pieceJointe = base64Data;
                        tache.pieceJointeContentType = $file.type;
                    });
                };
            }
        };
}]);
