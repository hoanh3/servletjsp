CREATE DATABASE QLHQ
GO

USE QLHQ
GO

CREATE TABLE [role] (
  [id] int PRIMARY KEY IDENTITY(1,1),
  [name] varchar(10) NOT NULL
)
GO

CREATE TABLE [user] (
  [id] int PRIMARY KEY IDENTITY(1,1),
  [fullname] nvarchar(50) NOT NULL,
  [email] nvarchar(150) NOT NULL,
  [password] nvarchar(72) NOT NULL,
  [phonenumber] varchar(20),
  [address] nvarchar(150),
  [role_id] int,
  [create_at] datetime,
  [update_at] datetime,
  [delete] int
)
GO

CREATE TABLE [category] (
  [int] int PRIMARY KEY IDENTITY(1,1),
  [name] nvarchar(50) NOT NULL,
  [thumbnail] nvarchar(200) NOT NULL
)
GO

CREATE TABLE [product] (
  [id] int PRIMARY KEY IDENTITY(1,1),
  [title] nvarchar(50) NOT NULL,
  [price] int NOT NULL,
  [discount] int NOT NULL,
  [thumbnail] nvarchar(200) NOT NULL,
  [description] text NOT NULL,
  [availability] int NOT NULL,
  [create_at] datetime NOT NULL,
  [update_at] datetime NOT NULL,
  [category_id] int NOT NULL,
  [delete] int NOT NULL
)
GO

CREATE TABLE [galery] (
  [id] int PRIMARY KEY IDENTITY(1,1),
  [product_id] int NOT NULL,
  [thumbnail] nvarchar(200) NOT NULL
)
GO

CREATE TABLE [review] (
  [id] int PRIMARY KEY IDENTITY(1,1),
  [rate] int,
  [content] nvarchar(200) NOT NULL,
  [user_id] int NOT NULL,
  [product_id] int NOT NULL
)
GO

CREATE TABLE [feedback] (
  [id] int PRIMARY KEY IDENTITY(1,1),
  [fullname] nvarchar(50) NOT NULL,
  [email] nvarchar(150) NOT NULL,
  [phonenumber] varchar(20) NOT NULL,
  [subject] nvarchar(100) NOT NULL,
  [note] nvarchar(200) NOT NULL
)
GO

CREATE TABLE [order] (
  [id] int PRIMARY KEY IDENTITY(1,1),
  [fullname] nvarchar(50) NOT NULL,
  [email] nvarchar(150) NOT NULL,
  [phonenumber] varchar(20) NOT NULL,
  [address] nvarchar(150) NOT NULL,
  [note] nvarchar(200) NOT NULL,
  [order_date] datetime NOT NULL,
  [status] int NOT NULL,
  [total_money] int NOT NULL,
  [user_id] int NOT NULL
)
GO

CREATE TABLE [order_detail] (
  [id] int PRIMARY KEY IDENTITY(1,1),
  [order_id] int NOT NULL,
  [product_id] int NOT NULL,
  [price] int NOT NULL,
  [num] int NOT NULL
)
GO

ALTER TABLE [user] ADD FOREIGN KEY ([role_id]) REFERENCES [role] ([id])
GO

ALTER TABLE [review] ADD FOREIGN KEY ([user_id]) REFERENCES [user] ([id])
GO

ALTER TABLE [review] ADD FOREIGN KEY ([product_id]) REFERENCES [product] ([id])
GO

ALTER TABLE [product] ADD FOREIGN KEY ([category_id]) REFERENCES [category] ([int])
GO

ALTER TABLE [galery] ADD FOREIGN KEY ([product_id]) REFERENCES [product] ([id])
GO

ALTER TABLE [order_detail] ADD FOREIGN KEY ([order_id]) REFERENCES [order] ([id])
GO

ALTER TABLE [order_detail] ADD FOREIGN KEY ([product_id]) REFERENCES [product] ([id])
GO
