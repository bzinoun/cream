'use strict';

angular.module('creamApp')
    .factory('RefStatutCompagneSearch', function ($resource) {
        return $resource('api/_search/refStatutCompagnes/:query', {}, {
            'query': { method: 'GET', isArray: true}
        });
    });
