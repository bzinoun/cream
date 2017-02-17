'use strict';

angular.module('creamApp')
    .controller('PerferenceController', function ($scope, $state, DataUtils, Perference, PerferenceSearch, ParseLinks , ImportProspect) {

        $scope.perferences = [];
        $scope.predicate = 'id';
        $scope.reverse = true;
        $scope.page = 1;
        $scope.loadAll = function() {
            Perference.query({page: $scope.page - 1, size: 20, sort: [$scope.predicate + ',' + ($scope.reverse ? 'asc' : 'desc'), 'id']}, function(result, headers) {
                $scope.links = ParseLinks.parse(headers('link'));
                $scope.totalItems = headers('X-Total-Count');
                $scope.perferences = result;
            });
        };
        $scope.loadPage = function(page) {
            $scope.page = page;
            $scope.loadAll();
        };
        $scope.loadAll();


        $scope.search = function () {
            PerferenceSearch.query({query: $scope.searchQuery}, function(result) {
                $scope.perferences = result;
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
        $scope.importProspect = function () {
        	
        	ImportProspect.save();
        	
        	
        	
        };

        $scope.clear = function () {
            $scope.perference = {
                sujet: null,
                description: null,
                dateImport: null,
                pieceJointe: null,
                pieceJointeContentType: null,
                id: null
            };
        };

        $scope.abbreviate = DataUtils.abbreviate;

        $scope.byteSize = DataUtils.byteSize;
    });
