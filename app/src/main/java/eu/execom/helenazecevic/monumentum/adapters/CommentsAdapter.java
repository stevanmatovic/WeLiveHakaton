package eu.execom.helenazecevic.monumentum.adapters;

import android.content.Context;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.ArrayList;
import java.util.List;

import eu.execom.helenazecevic.monumentum.models.Comment;
import eu.execom.helenazecevic.monumentum.views.CommentsView;
import eu.execom.helenazecevic.monumentum.views.CommentsView_;

/**
 * Created by Helena Zecevic on 28.05.2016..
 */
@EBean
public class CommentsAdapter extends BaseAdapter {

    private List<Comment> comments;

    @RootContext
    Context context;

    @AfterInject
    void afterInject() {
        comments = new ArrayList<>();
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return comments.size();
    }

    @Override
    public Object getItem(int i) {
        return comments.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        CommentsView commentsView;

        if (view == null) {
            commentsView = CommentsView_.build(context);
        } else {
            commentsView = (CommentsView) view;
        }

        commentsView.bind((Comment) getItem(i));

        return commentsView;

    }
}
