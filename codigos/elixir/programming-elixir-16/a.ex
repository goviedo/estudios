defmodule Pruebas do
  def inicio do
    IO.puts("hola")
  end

  def conwith do
    lp =
        with {:ok, file} = File.open("/etc/passwd"),
        content = IO.read(file, :all),
        :ok = File.close(file),
        [_, uid, gid] = Regex.run(~r/^_lp:.*?:(\d+)+(\d+):(\d+)/m, content) do
        "Group: #{gid}, User: #{uid}"
      end
    lp
  end

  def pr do
    lp = 
      with {:ok, file} = File.open("/etc/passwd"),
      content = IO.read(file, :all),
      :ok     = File.close(file)
      do
        content
      end
  end
end
