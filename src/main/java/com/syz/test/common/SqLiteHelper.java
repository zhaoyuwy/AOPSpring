package com.syz.test.common;

 

    public class SqLiteHelper
    {
        /// <summary>
        /// ConnectionStringÑùÀý£ºDatasource=Test.db3;Pooling=true;FailIfMissing=false
        /// </summary>
     /*   public static String ConnectionString
        {
            get
            {
                return  @"Data source= "+DataBasePath+";";
            }
            set { throw new NotImplementedException(); }
        }
 
        public static string DataBasePath
        {
            get { return "SpringYang.db";};
        }
 
        private static object lockObject = new object();
 
        private static void PrepareCommand(SQLiteCommand cmd, SQLiteConnection conn, string cmdText, List<SQLiteParameter> parameters)
        {
            if (conn.State != ConnectionState.Open)
                conn.Open();
            cmd.Parameters.Clear();
            cmd.Connection = conn;
            cmd.CommandText = cmdText;
            cmd.CommandType = CommandType.Text;
            cmd.CommandTimeout = 30;
            foreach (var parameter in parameters)
            {
                cmd.Parameters.Add(parameter);
            }
        }
 
        public static DataSet ExecuteQuery(string cmdText, List<SQLiteParameter> parameters)
        {
            lock (lockObject)
            {
                using (SQLiteConnection conn = new SQLiteConnection(ConnectionString))
                {
                    using (SQLiteCommand command = new SQLiteCommand())
                    {
                        DataSet ds = new DataSet();
                        PrepareCommand(command, conn, cmdText, parameters);
                        SQLiteDataAdapter da = new SQLiteDataAdapter(command);
                        da.Fill(ds);
                        return ds;
                    }
                }
            }
        }
 
        public static int ExecuteNonQuery(string cmdText, List<SQLiteParameter> parameters)
        {
            lock (lockObject)
            {
                using (SQLiteConnection conn = new SQLiteConnection(ConnectionString))
                {
                    using (SQLiteCommand command = new SQLiteCommand())
                    {
 
                        PrepareCommand(command, conn, cmdText, parameters);
                        return command.ExecuteNonQuery();
                    }
                }
            }
        }
 
        public static SQLiteDataReader ExecuteReader(string cmdText, List<SQLiteParameter> parameters)
        {
            lock (lockObject)
            {
                SQLiteConnection conn = new SQLiteConnection(ConnectionString);
 
                SQLiteCommand command = new SQLiteCommand();
 
                PrepareCommand(command, conn, cmdText, parameters);
                SQLiteDataReader sqLiteDataReader = command.ExecuteReader();
                return sqLiteDataReader;
            }
        }
 
        public static object ExecuteScalar(string cmdText, List<SQLiteParameter> parameters)
        {
            lock (lockObject)
            {
                using (SQLiteConnection conn = new SQLiteConnection(ConnectionString))
                {
                    using (SQLiteCommand command = new SQLiteCommand())
                    {
                        PrepareCommand(command, conn, cmdText, parameters);
                        return command.ExecuteScalar();
                    }
                }
            }
        }
        public static void CreateDataBase()
        {
            if (!File.Exists(DataBasePath))
                SQLiteConnection.CreateFile(DataBasePath);
            CreateTable();
        }
 
 
        public static void CreateTable()
        {
            ExecuteNonQuery(CodeDetailTabale, null);
        }
 
 
        private static string CodeDetailTabale
        {
            get
            {
                return @"CREATE TABLE  [CodeDetail] (
 [CdType] [nvarchar] (10)  NOT NULL ,
 [CdCode] [nvarchar] (20)  NOT NULL ,
 [CdString1] [ntext]   NOT NULL ,
 [CdString2] [ntext]   NOT NULL ,
 [CdString3] [ntext]   NOT NULL,
  PRIMARY KEY (CdType,CdCode)         
   ) ;";
            }
        }*/
    }
