'use strict';

angular.module('creamApp')
    .factory('RefStatutProspectionSearch', function ($resource) {
        return $resource('api/_search/refStatutProspections/:query', {}, {
            'query': { method: 'GET', isArray: true}
        });
    });
