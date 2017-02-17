'use strict';

angular.module('creamApp')
    .controller('RefStatutProspectionController', function ($scope, $state, RefStatutProspection, RefStatutProspectionSearch) {

        $scope.refStatutProspections = [];
        $scope.loadAll = function() {
            RefStatutProspection.query(function(result) {
               $scope.refStatutProspections = result;
            });
        };
        $scope.loadAll();


        $scope.search = function () {
            RefStatutProspectionSearch.query({query: $scope.searchQuery}, function(result) {
                $scope.refStatutProspections = result;
            }, function(response) {
                if(response.status === 404) {
                    $scope.loadAll();
                }
            });
        };

        $scope.refresh = function () {
            $scope.loadAll();
            $scope.clear();
        };

        $scope.clear = function () {
            $scope.refStatutProspection = {
                code: null,
                libelle: null,
                id: null
            };
        };
    });
