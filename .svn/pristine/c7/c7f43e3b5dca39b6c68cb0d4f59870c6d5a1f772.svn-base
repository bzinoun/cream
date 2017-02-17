'use strict';

angular.module('creamApp')
    .factory('CompagneSearch', function ($resource) {
        return $resource('api/_search/compagnes/:query', {}, {
            'query': { method: 'GET', isArray: true}
        });
    });
