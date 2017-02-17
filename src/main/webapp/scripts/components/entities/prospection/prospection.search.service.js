'use strict';

angular.module('creamApp')
    .factory('ProspectionSearch', function ($resource) {
        return $resource('api/_search/prospections/:query', {}, {
            'query': { method: 'GET', isArray: true}
        });
    });
