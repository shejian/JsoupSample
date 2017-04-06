package com.fiction.fiction.search.detail.presenter;

import com.fiction.fiction.search.detail.model.DetailModel;
import com.fiction.fiction.search.detail.view.DetailView;
import com.fiction.manager.Jsoup81Manager;
import com.framework.base.PresenterImplCompat;
import com.rxjsoupnetwork.manager.RxJsoupNetWork;

import org.jsoup.nodes.Document;

/**
 * by y on 2017/1/8.
 */

public class DetailPresenterImpl extends PresenterImplCompat<DetailModel, DetailView> implements DetailPresenter {

    public DetailPresenterImpl(DetailView view) {
        super(view);
    }

    @Override
    public void startDetail(final String url) {
        RxJsoupNetWork
                .getInstance()
                .getApi(
                        RxJsoupNetWork.onSubscribe(url, this),
                        this);
    }

    @Override
    public DetailModel getT(Document document) {
        return Jsoup81Manager.get(document).get81Detail();
    }
}