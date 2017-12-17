package eu.execom.helenazecevic.monumentum.views;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import eu.execom.helenazecevic.monumentum.R;
import eu.execom.helenazecevic.monumentum.models.Comment;
import eu.execom.helenazecevic.monumentum.models.LikeComment;
import eu.execom.helenazecevic.monumentum.models.LikeMonument;
import eu.execom.helenazecevic.monumentum.models.User;
import eu.execom.helenazecevic.monumentum.repository.CommentDAORepository;
import eu.execom.helenazecevic.monumentum.repository.LikeCommentDAORepository;
import eu.execom.helenazecevic.monumentum.repository.LikeMonumentDAORepository;

/**
 * Created by Helena Zecevic on 28.05.2016..
 */
@EViewGroup(R.layout.view_comments)
public class CommentsView extends LinearLayout {

    @ViewById
    TextView username;

    @ViewById
    TextView commentLikes;

    @ViewById
    ImageView likeComment;

    @ViewById
    TextView content;

    @ViewById
    TextView timestamp;

    @Bean
    LikeCommentDAORepository likeCommentDAORepository;

    @Bean
    CommentDAORepository commentDAORepository;

    private Comment comment;

    public CommentsView(Context context) {
        super(context);
    }

    public void bind(Comment comment) {
        this.comment = comment;
        final User user = comment.getUser();
        checkLiked();
        username.setText(user.getName());
        content.setText(comment.getContent());
        timestamp.setText(comment.getTimestamp().toString());
    }

    @Click(R.id.likeComment)
    @Background
    void toggle() {
        final boolean liked = likeCommentDAORepository.toggleLike(comment);
        updateLikeIcon(liked);
    }

    @Background
    void checkLiked() {
        final LikeComment liked = likeCommentDAORepository.userLiked(comment.getId());
        updateLikeIcon(liked != null);
    }

    @UiThread
    void updateLikeIcon(boolean liked) {
        likeComment.setImageResource(liked ? R.drawable.ic_favorite_white_36dp : R.drawable.ic_favorite_border_white_36dp);
        commentLikes.setText(String.valueOf(commentDAORepository.getLNumber(comment)));
    }
}
