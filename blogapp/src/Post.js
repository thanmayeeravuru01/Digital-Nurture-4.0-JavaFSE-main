import React from "react";

class Post extends React.Component {
  render() {
    const { title, body } = this.props;
    return (
      <article style={{ border: "1px solid #eee", padding: 12, marginBottom: 12, borderRadius: 8 }}>
        <h3 style={{ marginTop: 0 }}>{title}</h3>
        <p>{body}</p>
      </article>
    );
  }
}

export default Post;
