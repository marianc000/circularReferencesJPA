function div(val, className, id) {
    return `<div${id ? ' id="' + id + '" ' : ''}${className ? ' class="' + className + '"' : ''}>${val}</div>`;
}

function row(cname, aname = '', pname = '', lname = '', ai = 0, pi = 0, li = 0) {
    
    return div(div(cname, 'country a' + ai + ' p' + pi + ' l' + li)
            + div(aname, 'author a' + ai + ' p' + pi + ' l' + li)
            + div(pname, 'post a' + ai + ' p' + pi + ' l' + li)
            + div(lname, 'liked a' + ai + ' p' + pi + ' l' + li), 'row');
}

export function table(data, title) {
    if (!data)
        return '';

    return div(div(div(title, 'caption')
            + div(div('Country', 'country')
                    + div('Author', 'author')
                    + div('Post', 'post')
                    + div('Liked by', 'liked')
                    , 'row header') +
            data.flatMap((c, ci) => {
                if (!c.authors)
                    return row(c.COUNTRY_NAME);
                return c.authors.flatMap((a, ai) => {
                    if (!a.posts)
                        return row(c.COUNTRY_NAME, a.AUTHOR_NAME, '', '', ai);
                    return  a.posts.flatMap((p, pi) => {
                        if (!p.likes)
                            return row(c.COUNTRY_NAME, a.AUTHOR_NAME, p.POST_NAME, '', ai, pi);
                        return  p.likes.map((l, li) =>
                            row(c.COUNTRY_NAME, a.AUTHOR_NAME, p.POST_NAME, l.AUTHOR_NAME??l.FAN_NAME, ai, pi, li)
                        );
                    });
                });
            }).join(''), 'table ' + title), 'wrapper', title);
}
