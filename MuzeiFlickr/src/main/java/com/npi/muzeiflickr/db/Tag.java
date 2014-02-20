package com.npi.muzeiflickr.db;

import android.content.Context;

import com.npi.muzeiflickr.R;
import com.orm.SugarRecord;

/**
 * Created by nicolas on 17/02/14.
 */
public class Tag extends SugarRecord<Tag> implements RequestData {
    public Tag(Context context) {
        super(context);
    }

    public String term;
    public int page;
    int total;
    int current;

    public Tag(Context context, String term, int page, int current, int total) {
        super(context);
        this.term = term;
        this.page = page;
        this.current = current;
        this.total = total;

    }

    @Override
    public String getTitle() {
        return term;
    }

    @Override
    public int getIconRessource() {
        return R.drawable.icon_tag;
    }

    @Override
    public String getPhotoTotal() {
        return String.valueOf(total);
    }

    @Override
    public String getCurrentPhotoIndex() {
        return String.valueOf(current);
    }

    @Override
    public int getCurrentPage() {
        return page;
    }

    @Override
    public void setPage(int i) {
        page = i;
        save();
    }

    @Override
    public int getSourceType() {
        return SourceTypeEnum.TAG.ordinal();
    }

    @Override
    public long getSourceId() {
        return id;
    }

    @Override
    public void incrementCurrent() {
        current++;
        save();
    }
}