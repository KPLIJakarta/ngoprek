package id.or.linux.jakarta.pertemuan3;

public class Mapper {
	public static Object transformResult(Object ref, java.sql.ResultSet res)
	{
		try
		{
			int col = res.getMetaData().getColumnCount();
			String colName = null;
			for (int i = 1; i <= col; i++)
			{
				colName = res.getMetaData().getColumnName(i);
				try
				{
					java.lang.reflect.Field f = ref.getClass().getDeclaredField(colName.toLowerCase());
					if (f != null)
					{
						if (f.getType() == java.sql.Date.class)
						{
							f.set(ref, res.getDate(colName));
						}
						else
							if (f.getType() == int.class)
							{
								f.setInt(ref, res.getInt(colName));
							}
							else
							{
								f.set(ref, res.getString(colName));
							}
					}
				}
				catch (NoSuchFieldException nfe)
				{
					System.out.println("ScratchBook.transformResult, skipping " + colName);
				}
				catch (IllegalArgumentException il)
				{
					System.out.println("ScratchBook.transformResult, illegal value for " + colName);
				}
			}
		}
		catch (Throwable t)
		{
			System.out.println("ScratchBook.transformResult");
		}
		return null;
	}
}
