/*
 * This file is generated by jOOQ.
 */
package com.example.jooq.model;


import com.example.jooq.model.tables.Comments;
import com.example.jooq.model.tables.Posts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Test extends SchemaImpl {

    private static final long serialVersionUID = 1768692296;

    /**
     * The reference instance of <code>test</code>
     */
    public static final Test TEST = new Test();

    /**
     * The table <code>test.comments</code>.
     */
    public final Comments COMMENTS = com.example.jooq.model.tables.Comments.COMMENTS;

    /**
     * The table <code>test.posts</code>.
     */
    public final Posts POSTS = com.example.jooq.model.tables.Posts.POSTS;

    /**
     * No further instances allowed
     */
    private Test() {
        super("test", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        List result = new ArrayList();
        result.addAll(getTables0());
        return result;
    }

    private final List<Table<?>> getTables0() {
        return Arrays.<Table<?>>asList(
            Comments.COMMENTS,
            Posts.POSTS);
    }
}