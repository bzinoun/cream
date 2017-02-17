'use strict';

angular.module('creamApp')
    .controller('CompagneController', function ($scope, $state, Compagne, CompagneSearch, ParseLinks) {

        $scope.compagnes = [];
        $scope.predicate = 'id';
        $scope.reverse = true;
        $scope.page = 1;
        $scope.loadAll = function() {
            Compagne.query({page: $scope.page - 1, size: 20, sort: [$scope.predicate + ',' + ($scope.reverse ? 'asc' : 'desc'), 'id']}, function(result, headers) {
                $scope.links = ParseLinks.parse(headers('link'));
                $scope.totalItems = headers('X-Total-Count');
                $scope.compagnes = result;
            });
        };
        $scope.loadPage = function(page) {
            $scope.page = page;
            $scope.loadAll();
        };
        $scope.loadAll();


        $scope.search = function () {
            CompagneSearch.query({query: $scope.searchQuery}, function(result) {
                $scope.compagnes = result;
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
            $scope.compagne = {
                libelle: null,
                dateDebut: null,
                dateFin: null,
                id: null
            };
        };
    });
