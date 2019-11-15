package ycode.simplehttp;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.HttpObject;
import io.netty.handler.codec.http.HttpRequest;

public class HttpServerHandler extends SimpleChannelInboundHandler<HttpObject> {

    private SimpleHttpRequestHandler handler = new SimpleHttpRequestHandler();

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) throws Exception {
        if (msg instanceof HttpRequest) {
            ctx.write(handler.response((HttpRequest) msg));
        }else{
            ctx.write(handler.badRequest());
        }
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }
}
