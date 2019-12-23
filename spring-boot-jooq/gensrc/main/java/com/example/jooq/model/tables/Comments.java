/*
 * This file is generated by jOOQ.
 */
package com.example.jooq.model.tables;


import com.example.jooq.model.Indexes;
import com.example.jooq.model.Keys;
import com.example.jooq.model.Test;
import com.example.jooq.model.tables.records.CommentsRecord;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row6;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


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
public class Comments extends TableImpl<CommentsRecord> {

    private static final long serialVersionUID = 52550345;

    /**
     * The reference instance of <code>test.comments</code>
     */
    public static final Comments COMMENTS = new Comments();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CommentsRecord> getRecordType() {
        return CommentsRecord.class;
    }

    /**
     * The column <code>test.comments.ID</code>.
     */
    public final TableField<CommentsRecord, Integer> ID = createField(DSL.name("ID"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>test.comments.POST_ID</code>.
     */
    public final TableField<CommentsRecord, Integer> POST_ID = createField(DSL.name("POST_ID"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>test.comments.NAME</code>.
     */
    public final TableField<CommentsRecord, String> NAME = createField(DSL.name("NAME"), org.jooq.impl.SQLDataType.VARCHAR(200).nullable(false), this, "");

    /**
     * The column <code>test.comments.EMAIL</code>.
     */
    public final TableField<CommentsRecord, String> EMAIL = createField(DSL.name("EMAIL"), org.jooq.impl.SQLDataType.VARCHAR(200).nullable(false), this, "");

    /**
     * The column <code>test.comments.CONTENT</code>.
     */
    public final TableField<CommentsRecord, String> CONTENT = createField(DSL.name("CONTENT"), org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>test.comments.CREATED_ON</code>.
     */
    public final TableField<CommentsRecord, Timestamp> CREATED_ON = createField(DSL.name("CREATED_ON"), org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

    /**
     * Create a <code>test.comments</code> table reference
     */
    public Comments() {
        this(DSL.name("comments"), null);
    }

    /**
     * Create an aliased <code>test.comments</code> table reference
     */
    public Comments(String alias) {
        this(DSL.name(alias), COMMENTS);
    }

    /**
     * Create an aliased <code>test.comments</code> table reference
     */
    public Comments(Name alias) {
        this(alias, COMMENTS);
    }

    private Comments(Name alias, Table<CommentsRecord> aliased) {
        this(alias, aliased, null);
    }

    private Comments(Name alias, Table<CommentsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Comments(Table<O> child, ForeignKey<O, CommentsRecord> key) {
        super(child, key, COMMENTS);
    }

    @Override
    public Schema getSchema() {
        return Test.TEST;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.COMMENTS_POST_ID, Indexes.COMMENTS_PRIMARY);
    }

    @Override
    public Identity<CommentsRecord, Integer> getIdentity() {
        return Keys.IDENTITY_COMMENTS;
    }

    @Override
    public UniqueKey<CommentsRecord> getPrimaryKey() {
        return Keys.KEY_COMMENTS_PRIMARY;
    }

    @Override
    public List<UniqueKey<CommentsRecord>> getKeys() {
        return Arrays.<UniqueKey<CommentsRecord>>asList(Keys.KEY_COMMENTS_PRIMARY);
    }

    @Override
    public List<ForeignKey<CommentsRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<CommentsRecord, ?>>asList(Keys.COMMENTS_IBFK_1);
    }

    public Posts posts() {
        return new Posts(this, Keys.COMMENTS_IBFK_1);
    }

    @Override
    public Comments as(String alias) {
        return new Comments(DSL.name(alias), this);
    }

    @Override
    public Comments as(Name alias) {
        return new Comments(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Comments rename(String name) {
        return new Comments(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Comments rename(Name name) {
        return new Comments(name, null);
    }

    // -------------------------------------------------------------------------
    // Row6 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row6<Integer, Integer, String, String, String, Timestamp> fieldsRow() {
        return (Row6) super.fieldsRow();
    }
}