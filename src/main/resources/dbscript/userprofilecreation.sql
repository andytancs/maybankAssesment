create table  "dbo"."UserProfile"(
"id" INT not null  GENERATED ALWAYS AS identity PRIMARY KEY,
"name" text not null ,
"hashpassword" text not null,
"dob" text not null,
"balance" numeric not null,
constraint userprofilename UNIQUE(name)
);