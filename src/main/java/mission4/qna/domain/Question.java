package mission4.qna.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import mission4.qna.CannotDeleteException;

@Entity
public class Question extends AbstractEntity {

  @Column(length = 100, nullable = false)
  private String title;

  @Lob
  private String contents;

  @ManyToOne
  @JoinColumn(foreignKey = @ForeignKey(name = "fk_question_writer"))
  private User writer;

  @Embedded
  private final Answers answers = new Answers();

  private boolean deleted = false;

  public Question() {
  }

  public Question(String title, String contents) {
    this.title = title;
    this.contents = contents;
  }

  public Question(long id, String title, String contents) {
    super(id);
    this.title = title;
    this.contents = contents;
  }

  public String getTitle() {
    return title;
  }

  public Question setTitle(String title) {
    this.title = title;
    return this;
  }

  public String getContents() {
    return contents;
  }

  public Question setContents(String contents) {
    this.contents = contents;
    return this;
  }

  public User getWriter() {
    return writer;
  }

  public Question writeBy(User loginUser) {
    this.writer = loginUser;
    return this;
  }

  public void addAnswer(Answer answer) {
    answer.toQuestion(this);
    answers.answers().add(answer);
  }

  private boolean isOwner(User loginUser) {
    return writer.equals(loginUser);
  }

  private Question markDeleted() {
    this.deleted = true;
    return this;
  }

  public boolean isDeleted() {
    return deleted;
  }

  public void hasDeleteOwner(User loginUser) throws CannotDeleteException {
    if (!isOwner(loginUser)) {
      throw new CannotDeleteException("질문을 삭제할 권한이 없습니다.");
    }
  }

  private DeleteHistory deleteQuestion(User loginUser) throws CannotDeleteException {
    hasDeleteOwner(loginUser);
    return new DeleteHistory(markDeleted(), LocalDateTime.now());
  }

  private List<DeleteHistory> deleteAnswers(User loginUser) throws CannotDeleteException {
    answers.hasOthersAnswer(loginUser);
    return answers.answerHistories();
  }

  public List<DeleteHistory> delete(User loginUser) throws CannotDeleteException {
    List<DeleteHistory> deleteHistories = new ArrayList<>();
    deleteHistories.add(deleteQuestion(loginUser));
    deleteHistories.addAll(deleteAnswers(loginUser));
    return deleteHistories;
  }

  @Override
  public String toString() {
    return "Question [id=" + getId() + ", title=" + title + ", contents=" + contents + ", writer="
        + writer + "]";
  }
}
