import React from "react";
import Post from "./Post";

class Posts extends React.Component {
  constructor(props) {
    super(props);
    this.state = { posts: [], hasError: false };
    this.loadPosts = this.loadPosts.bind(this);
  }

  async loadPosts() {
    try {
      const res = await fetch("https://jsonplaceholder.typicode.com/posts");
      if (!res.ok) throw new Error(`HTTP ${res.status}`);
      const data = await res.json();
      this.setState({ posts: data });
    } catch (err) {
      this.setState({ hasError: true });
      alert("Failed to load posts: " + err.message);
    }
  }

  componentDidMount() {
    this.loadPosts();
  }

  componentDidCatch(error, info) {
    this.setState({ hasError: true });
    alert("Something went wrong in a child component: " + error.toString());
  }

  render() {
    const { hasError, posts } = this.state;
    if (hasError) return <h2>Sorry, something went wrong.</h2>;

    return (
      <main style={{ maxWidth: 800, margin: "40px auto", padding: "0 16px" }}>
        <h1>Blog Posts</h1>
        {posts.map((p) => (
          <Post key={p.id} title={p.title} body={p.body} />
        ))}
      </main>
    );
  }
}

export default Posts;
