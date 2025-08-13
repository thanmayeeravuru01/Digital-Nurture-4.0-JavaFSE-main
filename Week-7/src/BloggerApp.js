import React from 'react';

function BlogList({ blogs }) {
  return (
    <div className="blogger-app">
      <h2>Blogs</h2>
      <ul>
        {blogs.map((blog, index) => (
          <li key={index}>{blog.title} by {blog.author}</li>
        ))}
      </ul>
    </div>
  );
}

export default function BloggerApp() {
  const blogs = [
    { title: "React Basics", author: "Teja" },
    { title: "Props & State", author: "Teja" }
  ];

  return <BlogList blogs={blogs} />;
}
