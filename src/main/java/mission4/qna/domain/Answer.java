package mission4.qna.domain;

import mission4.qna.CannotDeleteException;
import mission4.qna.NotFoundException;
import mission4.qna.UnAuthorizedException;

import javax.persistence.*;

@Entity
public class Answer extends AbstractEntity {

  @ManyToOne(optional = false)
  @JoinColumn(foreignKey = @ForeignKey(name = "fk_answer_writer"))
  private User writer;

  @ManyToOne(optional = false)
  @JoinColumn(foreignKey = @ForeignKey(name = "fk_answer_to_question"))
  private Question question;

  @Lob
  private String contents;

  private boolean deleted = false;

  public Answer() {
  }

  public Answer(User writer, Question question, String contents) {
    this(null, writer, question, contents);
  }

  public Answer(Long id, User writer, Question question, String contents) {
    super(id);

    if (writer == null) {
      throw new UnAuthorizedException();
    }

    if (question == null) {
      throw new NotFoundException();
    }

    this.writer = writer;
    this.question = question;
    this.contents = contents;
  }

  protected Answer markDeleted() {
    this.deleted = true;
    return this;
  }

  public boolean isDeleted() {
    return deleted;
  }

  public void hasOthers(User loginUser) throws CannotDeleteException {
    if (!isOwner(loginUser)) {
      throw new CannotDeleteException("다른 사람이 쓴 답변이 있어 삭제할 수 없습니다.");
    }
  }

  private boolean isOwner(User writer) {
    return this.writer.equals(writer);
  }

  public User getWriter() {
    return writer;
  }

  public String getContents() {
    return contents;
  }

  public void toQuestion(Question question) {
    this.question = question;
  }

  @Override
  public String toString() {
    return "Answer [id=" + getId() + ", writer=" + writer + ", contents=" + contents + "]";
  }
}
