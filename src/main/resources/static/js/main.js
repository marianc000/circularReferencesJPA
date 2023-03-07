import { table } from './table.js';

import {compare} from './compare.js';

const BASE_URL = '/api/';

const PATHS = ['jpa',  'jdbc'];
const links = '<div class="links">' + PATHS.map(p => `<a href="#${p}">${p}</a>`).join('') + '</div>';
//  
Promise.all(
        PATHS.map(path => fetch(BASE_URL + path).then(r => r.json())))
        .then(ar => {
            console.log(...ar);
            compare(...ar);

            rootDiv.innerHTML = links + PATHS.map((p, i) => table(ar[i], p)).join('');
        });


