'use strict';

angular.module('creamApp')
    .controller('TacheController', function ($scope, $state, DataUtils, Tache, TacheSearch, ParseLinks) {
        $scope.taches = [];
        $scope.predicate = 'id';
        $scope.reverse = true;
        $scope.page = 1;
        $scope.loadAll = function() {
            Tache.query({page: $scope.page - 1, size: 20, sort: [$scope.predicate + ',' + ($scope.reverse ? 'asc' : 'desc'), 'id']}, function(result, headers) {
                $scope.links = ParseLinks.parse(headers('link'));
                $scope.totalItems = headers('X-Total-Count');
                $scope.taches = result;
            });
        };
        $scope.loadPage = function(page) {
            $scope.page = page;
            $scope.loadAll();
        };
        $scope.loadAll();


        $scope.search = function () {
            TacheSearch.query({query: $scope.searchQuery}, function(result) {
                $scope.taches = result;
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
        
        $scope.goProspectionDetail = function (tache) {
        	
        	$state.go("prospection.detail", { id: tache.prospectionId ,tacheId:tache.id});
        	
        };

        $scope.clear = function () {
            $scope.tache = {
                sujet: null,
                description: null,
                dateDebut: null,
                dateFin: null,
                type: null,
                pieceJointe: null,
                pieceJointeContentType: null,
                user: null,
                id: null
            };
        };

        $scope.abbreviate = DataUtils.abbreviate;

        $scope.byteSize = DataUtils.byteSize;
    });
